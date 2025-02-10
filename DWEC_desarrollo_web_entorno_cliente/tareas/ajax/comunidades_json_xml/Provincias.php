<?php
class Provincias
{
    public $id;
    public $nombre;
    public $id_comunidad;

    public function __construct($id, $nombre, $id_comunidad)
    {
        $this->id = $id;
        $this->nombre = $nombre;
        $this->id_comunidad = $id_comunidad;
    }

    public function getId()
    {
        return $this->id;
    }

    public function getNombre()
    {
        return $this->nombre;
    }

    public function getId_comunidad()
    {
        return $this->id_comunidad;
    }
}
