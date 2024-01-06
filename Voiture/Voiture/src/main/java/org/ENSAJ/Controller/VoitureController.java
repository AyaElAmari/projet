package org.ENSAJ.Controller;

import org.ENSAJ.Model.Voiture;
import org.ENSAJ.RabbitMQ.CustomMessage;
import org.ENSAJ.RabbitMQ.MQConfig;
import org.ENSAJ.Repository.VoitureRepository;
import org.ENSAJ.Service.VoitureService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class VoitureController {

    @Autowired
    VoitureRepository voitureRepository;

    @Autowired
    VoitureService voitureService;

    @Autowired
    private RabbitTemplate template;

    @GetMapping(value ="/voitures", produces = {"application/json"})
    public ResponseEntity<List<Voiture>> chercherVoiture(){
        CustomMessage message = new CustomMessage();
        message.setMessage("Bonjour Ayah,  Liste des voitures - Microservice:Voiture");
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);
        System.out.println("Message delivered");
        return ResponseEntity.ok(voitureRepository.findAll());
    }

    @GetMapping("/voitures/{Id}")
    public Voiture chercherUneVoiture(@PathVariable Long Id) throws Exception{
        CustomMessage message = new CustomMessage();
        message.setMessage("Bonjour Ayah,  Renvoie d'une voiture - Microservice:Voiture");
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);
        System.out.println("Message delivered");
        return voitureRepository.findById(Id).orElseThrow(() -> new Exception("Voiture Introuvable"));
    }

    @GetMapping("/voitures/client/{Id}")
    public List<Voiture> chercherVoitureParClient(@PathVariable Long Id){
        CustomMessage message = new CustomMessage();
        message.setMessage("Bonjour Ayah, Renvoie des voitures d'un client - Microservice:Voiture");
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);
        System.out.println("Message delivered");
        return voitureRepository.findByClientId(Id);
    }

    @PostMapping("/voitures")
    public Voiture enregistrerUneVoiture(@RequestBody Voiture voiture){
        return voitureService.enregistrerVoiture(voiture);
    }



}
