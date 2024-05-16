package fr.formation.paiementservice.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.formation.paiementservice.dto.UserResponse;
import fr.formation.paiementservice.model.SoldeUtilisateur;
import fr.formation.paiementservice.repo.SoldeUtilisateurRepository;
import fr.formation.paiementservice.request.CreateSoldeRequest;
import fr.formation.paiementservice.response.SoldeResponse;

@RestController
@RequestMapping("/api/solde-utilisateur")
public class SoldeUtilisateurController {


	@Autowired
	private SoldeUtilisateurRepository repository;

	@GetMapping
	public List<SoldeResponse> findAll() {
		List<SoldeUtilisateur> soldes = this.repository.findAll();
		List<SoldeResponse> response = new ArrayList<>();

		for (SoldeUtilisateur solde : soldes) {
			SoldeResponse soldeResponse = new SoldeResponse();

			BeanUtils.copyProperties(solde, soldeResponse);

			response.add(soldeResponse);

		}

		return response;
	}


	@GetMapping("/{userId}")
	public UserResponse findById(@PathVariable("userId") String userId) {

		UserResponse userResponse = new UserResponse();
		Optional<SoldeUtilisateur> user = this.repository.findById(userId);
		if (user.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		BeanUtils.copyProperties(user.get(), userResponse);
		return userResponse;
	}



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody CreateSoldeRequest request) {
		SoldeUtilisateur solde = new SoldeUtilisateur();

		BeanUtils.copyProperties(request, solde);

		this.repository.save(solde);

		return solde.getUserId();
	}

}
