package QueMePongo.Servicio;

import java.io.IOException;

import QueMePongo.Dominio.Evento;

public interface IComand {

public Evento Execute(Evento evento) throws IOException ;
}
