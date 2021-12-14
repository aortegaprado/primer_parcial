package dto;

import com.gdd.primer_parcial.model.Contactos;
import com.gdd.primer_parcial.model.UsuarioPremio;
import lombok.Data;

import java.util.List;

@Data
public class UsuariosDTO {
    private Integer idUsuario;
    private ContactosDTO contactos;
    private String nombre;
    private String estado;
    private Integer posicionPremio;
    private Integer cantIntentos;
    private String telefono;
    private String email;
    private List<UsuarioPremioDTO> usuarioPremios;

}
