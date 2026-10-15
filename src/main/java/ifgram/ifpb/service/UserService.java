package ifgram.ifpb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ifgram.ifpb.repository.UserRepository;
import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ifgram.ifpb.dto.UserRequest;
import ifgram.ifpb.dto.UserResponse;
import ifgram.ifpb.model.User;


@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    @Transactional
    public UserResponse criar(UserRequest request) throws Exception {
        if(repository.existsByEmail(request.email())){
            throw new Exception("Email já cadastrado: " + request.email());
        }
        User usuarioNovo = new User(request.nome(), request.email());
        User usuarioSalvo = repository.save(usuarioNovo);

        return UserResponse.from(usuarioSalvo);
    }

    public List<UserResponse> buscarTodosUsuarios() {
        List<User> listaUsuarios = repository.findAll();
        List<UserResponse> listaUsuariosResponse = new ArrayList<>();
        UserResponse userReponse;
        for (User user : listaUsuarios) {
            userReponse = new UserResponse(
                    user.getId(),
                    user.getNome(),
                    user.getEmail()
            );
            listaUsuariosResponse.add(userReponse);
        }
        return listaUsuariosResponse;

        public UserResponse atualizarUsuario(UserRequest UserRequest) throw Expection {
            Optional<User> usuario = repository.findByEmail(userRequest.email());
            if (usuario.isEmpty()) {
                throw new Expection("usuário não existe na base de dados.");
            }
            User usuarioSalvo = usuario.get();
            usuarioSalvo.setNome(request.nome());
            repository.save(usuarioSalvo);

            return UserResponse.from(usuarioSalvo);
        }
    }

}