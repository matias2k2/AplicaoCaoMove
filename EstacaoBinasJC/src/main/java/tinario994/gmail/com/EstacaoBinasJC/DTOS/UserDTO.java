package tinario994.gmail.com.EstacaoBinasJC.DTOS;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import tinario994.gmail.com.EstacaoBinasJC.Models.User;

@Getter
@Setter
public class UserDTO implements Serializable  {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private boolean isActive;
	
	public UserDTO() {
	}

    public UserDTO(Integer id, String name, String email, String password, boolean isActive) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}
    public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
		this.isActive = entity.isActive();
	}
    
}
