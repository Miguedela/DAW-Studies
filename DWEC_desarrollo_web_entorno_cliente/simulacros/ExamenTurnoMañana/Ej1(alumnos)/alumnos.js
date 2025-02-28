class Alumno {
  constructor(nombre, curso, dominio) {
    this.nombre = nombre;
    this.curso = curso;
    this.dominio = dominio;
    this.notas = [];
  }

  get nombrePila() {
    const partes = this.nombre.split(";");
    return partes[2].trim();
  }

  get correo() {
    const partes = this.nombre.split(";");
    const iniciales =
      partes[0].trim().charAt(0).toLowerCase() +
      "." +
      partes[1].trim().charAt(0).toLowerCase();
    const apellidos =
      partes[0].trim().toLowerCase().replace(" ", "-") +
      "-" +
      partes[1].trim().toLowerCase().replace(" ", "-");
    return `${iniciales}.${apellidos}@${this.dominio}`;
  }

  añadirNota(...nuevasNotas) {
    this.notas.push(...nuevasNotas);
  }

  notaMedia() {
    if (this.notas.length === 0) return -1;

    let suma = 0;
    for (let i = 0; i < this.notas.length; i++) {
      suma += this.notas[i];
    }

    return parseFloat((suma / this.notas.length).toFixed(1));
  }
}
