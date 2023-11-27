package org.bank.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role implements GrantedAuthority{
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name="role_id")
        @JsonIgnore
        private Integer roleId;
        @NotNull
        private String authority;

        public Role(){
                super();
        }

        public Role(String authority){
                this.authority = authority;
        }
        @Override
        public String getAuthority() {
                // TODO Auto-generated method stub
                return this.authority;
        }
        public Role(Integer roleId, String authority){
                this.roleId = roleId;
                this.authority = authority;
        }
        public void setAuthority(String authority){
                this.authority = authority;
        }

        public Integer getRoleId(){
                return this.roleId;
        }

        public void setRoleId(Integer roleId){
                this.roleId = roleId;
        }
}
