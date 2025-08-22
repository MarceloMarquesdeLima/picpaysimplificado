package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validetionTransaction (User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() != UserType.MERCHANT) {
            throw new Exception("Usuário lojista não está autorizado a realizar a transação!");
        }
        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Usuário não tem saldo suficinete!");
        }
    }
    public User findUserById(long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(()-> new Exception("Usuário não encontrado!"));
    }
}
