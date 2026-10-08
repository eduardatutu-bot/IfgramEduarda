package ifgram.ifpb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

    @Entity
    @Table(name = "tb_user")
    public class UserModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 120)
        private String nome;

        @Column(nullable = true, unique = true)
        private String email;

        public UserModel() {
        }

        public UserModel(String nome, String email){
            this.nome = nome;
            this.email = email;
        }

        public Long getId(){
            return this.id;
        }

        public String getNome(){
            return this.nome;
        }

        public String getEmail(){
            return this.email;
        }

    }
