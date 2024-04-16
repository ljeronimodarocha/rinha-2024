package git.ljeronimodarocha.entity.enums;


import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoTransacao {
    c, d;
}
