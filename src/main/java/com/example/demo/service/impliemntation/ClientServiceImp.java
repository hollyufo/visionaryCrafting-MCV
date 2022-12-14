package com.example.demo.service.impliemntation;

import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getOnById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client addClient(Client client) {
        Pattern patternEmail = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,})$");
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        if (client.getEmail()!=null && client.getPassword() !=null && client.getTel() !=null){
            Matcher matcherEmail = patternEmail.matcher(client.getEmail());
            Matcher matcherPassword = patternPassword.matcher(client.getPassword());
            if(matcherEmail.matches() && matcherPassword.matches()) {
                Optional<Client> clientByEmail = clientRepository.findByEmail(client.getEmail());
                if (clientByEmail.isPresent()) {
                    throw new IllegalStateException("Email existe déja");
                } else {
                    return clientRepository.save(client);
                }
            }else{
                throw new IllegalStateException("Email or password Format Invalid");
            }
        }else{
            throw new IllegalStateException("il faut remplire tous les champs");
        }
    }

    @Transactional
    @Override
    public Client updateClient(Long id, Client client) {
        Client clientById = clientRepository.findById(id).orElse(null);
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        if(clientById != null){
            if (client.getEmail()!=null && client.getPassword() !=null && client.getTel() !=null){
                Matcher matcherPassword = patternPassword.matcher(client.getPassword());
                if(clientById.getEmail().equals(client.getEmail()) && matcherPassword.matches()) {
                    clientById.setEmail(client.getEmail());
                    clientById.setPassword(client.getPassword());
                    clientById.setTel(client.getTel());
                    return clientById;
                }else{
                    if(!clientById.getEmail().equals(client.getEmail())){
                        throw new IllegalStateException("vous n'avez pas le droit de changer l'adresse email");
                    }else{
                        throw new IllegalStateException("password Format Invalid");
                    }
                }
            }else{
                throw new IllegalStateException("il faut remplire tous les champs");
            }
        }else{
            throw new IllegalStateException("id non trouvé");
        }
    }
    // delete client
    public void deleteClient(Long id) {
        boolean exists = clientRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("id non trouvé");
        }else{
            clientRepository.deleteById(id);
        }
    }

}
