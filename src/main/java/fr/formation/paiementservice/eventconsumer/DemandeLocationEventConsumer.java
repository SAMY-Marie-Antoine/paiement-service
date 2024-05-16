package fr.formation.paiementservice.eventconsumer;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import fr.formation.paiementservice.event.DemandeLocationEvent;
import fr.formation.paiementservice.model.SoldeUtilisateur;
import fr.formation.paiementservice.repo.SoldeUtilisateurRepository;

@Component("onDemandeLocation")
public class DemandeLocationEventConsumer implements Consumer<DemandeLocationEvent> {

    @Autowired
    SoldeUtilisateurRepository daoSolde;

    @Autowired
    StreamBridge streamBridge;

    @Override
    public void accept(DemandeLocationEvent event) {
       Optional<SoldeUtilisateur> soldeUtilisateur = daoSolde.findById(event.getUserId());
        if(soldeUtilisateur.isEmpty()) //refus utilisateur non trouvé
        {
            streamBridge.send("refus.location",event);
        }
        else if(soldeUtilisateur.get().getSolde().compareTo(event.getPrixLocation()) != -1) //solde egal ou supérieur au prix de la location
        {
            soldeUtilisateur.get().setSolde(
                soldeUtilisateur.get().getSolde().subtract(event.getPrixLocation())
            );
            daoSolde.save(soldeUtilisateur.get());
            streamBridge.send("ok.location",event);
        }
        else //refus solde insuffisant
        {
            streamBridge.send("refus.location",event);
        }

    }


}
