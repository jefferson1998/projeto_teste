/*
 * Copyright 2018 Rodrigo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ifpe.edu.smbg.model.entity;

import java.util.Objects;

/**
 *
 * @author Rodrigo
 */
public class Usuario {
    
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario() {
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        
        if(this == o)
            return true;
        
        if(!(o instanceof Usuario))
            return false;
        
        Usuario usuario = (Usuario) o;
        return usuario.getLogin().equals(this.login) && usuario.getSenha().equals(this.senha);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.login, this.senha);
    }

    
    
    
    
}
