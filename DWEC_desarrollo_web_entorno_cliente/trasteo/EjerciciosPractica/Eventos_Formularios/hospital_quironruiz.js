let SEGUROS_MEDICOS = [
  { value: 1, texto: "Adeslas" },
  { value: 2, texto: "Asisa" },
  { value: 3, texto: "Caser Salud" },
  { value: 4, texto: "DKV" },
  { value: 5, texto: "Mapfre" },
  { value: 6, texto: "Sanitas" },
];

// Escribe aquí tu código
addEventListener("load", inicio); // Evento de cargar la página

//Funcion inicio
function inicio() {
  // a) Establezco el campo de nombre y apellidos como requeridos
  document.getElementById("inputNombre").setAttribute("required", "required");
  document
    .getElementById("inputApellidos")
    .setAttribute("required", "required");

  // b) Comprobacion del dnidocument
  document.getElementById("inputDNI").setAttribute("required", "required");
  let formulario = document.querySelector('[name="miformulario"]');
  formulario.addEventListener("submit", dniComprobar);

  // c) Rellenar select seguro médico
  let select = document.getElementById("inputSeguroMedico");
  let option;
  for (const element of SEGUROS_MEDICOS) {
    option = document.createElement("option");
    option.innerHTML = element.texto;
    option.setAttribute("value", element.value);
    select.appendChild(option);
  }

  // d) Habilitar los especialistas si se marca el checkbox
  let especiaRadio = document.getElementById("inputMedicoEspecialista");
  especiaRadio.addEventListener("change", habilitarEspecialistas);
  let familiaRadio = document.getElementById("inputMedicoFamilia");
  familiaRadio.addEventListener("change", habilitarEspecialistas);

  // c) Fecha requerida y entre dias concretos
  let inputFecha = document.getElementById("inputFechaCita");
  inputFecha.setAttribute("required", "required"); // Fecha requerida
  inputFecha.addEventListener("input", validarFechaCita);

  // d) Hora requerida y en horarios concretos
  let inputHora = document.getElementById("inputHoraCita");
  inputHora.setAttribute("required", "required"); // Fecha requerida
  inputHora.addEventListener("input", validarHoraCita);
}

// Funcion para la comprobación del input DNI
function dniComprobar(evt) {
  evt.preventDefault(); // Prevengo la actualizacion de la pagina para no perder los mensajes de error

  let inputDni = document.getElementById("inputDNI");
  let expresionRegularDni = /^\d{8}[trwagmyfpdxbnjzsqvhlcke]$/i;

  // Busco el elemanto span error
  let existingError = inputDni.parentElement.querySelector(".error-message");

  //If para mostrar o eliminar el mensaje de error
  if (!expresionRegularDni.test(inputDni.value)) {
    if (!existingError) {
      let span = document.createElement("span");
      span.className = "error-message";
      span.textContent = "Formato de DNI no válido";
      inputDni.parentElement.appendChild(span);
    }
  } else {
    if (!existingError && !validarDNI(inputDni.value)) {
      let span = document.createElement("span");
      span.className = "error-message";
      span.textContent = "Letra no valida";
      inputDni.parentElement.appendChild(span);
    } else if (!existingError && validarDNI(inputDni.value)) {
      existingError.remove();
    }
  }
}

// Función auxiliar para comprobar la letra de un DNI
function validarDNI(dni) {
  // Tabla de letras para el DNI
  const letrasDni = [
    "T",
    "R",
    "W",
    "A",
    "G",
    "M",
    "Y",
    "F",
    "P",
    "D",
    "X",
    "B",
    "N",
    "J",
    "Z",
    "S",
    "Q",
    "V",
    "H",
    "L",
    "C",
    "K",
    "E",
  ];

  let numDni = parseInt(dni.substring(0, dni.length - 1));
  let letraDni = dni.substring(dni.length - 1);

  let indice = numDni % 23;

  if (letrasDni[indice].toLowerCase() == letraDni.toLowerCase()) {
    return true;
  } else {
    return false;
  }
}

// Funcion para rellenar los seguros medicos
function habilitarEspecialistas() {
  if (document.getElementById("inputMedicoFamilia").checked) {
    document.getElementById("inputEspecialidad").disabled = true;
    document.getElementById("inputEspecialidad").required = true;
  } else {
    document.getElementById("inputEspecialidad").disabled = false;
    document.getElementById("inputEspecialidad").required = false;
  }
}

// Funcion para comprobare el día de la semana que elige
function validarFechaCita(evt) {
  const fechaSeleccionada = new Date(evt.target.value);
  const diaSemana = fechaSeleccionada.getDay();
  let errorFechaCita = evt.target.parentElement.querySelector(".error-message");

  // Si no existe un mensaje de error, lo creamos
  if (!errorFechaCita) {
    errorFechaCita = document.createElement("span");
    errorFechaCita.className = "error-message"; // Añadir clase para estilizar
    evt.target.parentElement.appendChild(errorFechaCita);
  }

  // Validar si el día está entre lunes (1) y jueves (4)
  if (diaSemana >= 1 && diaSemana <= 4) {
    errorFechaCita.textContent = ""; // Borrar el mensaje de error si es válido
    // evt.target.setCustomValidity(""); // Validación correcta
  } else {
    errorFechaCita.textContent =
      "El día de la cita sólo puede ser de lunes a jueves."; // Mostrar error
    // evt.target.setCustomValidity("Invalid"); // Marcar el campo como inválido
  }
}

// Funcion para comprobare la hora dependiendo del día
function validarHoraCita(evt) {
  const inputHora = evt.target.value;
  const fechaSeleccionada = new Date(
    document.getElementById("inputFechaCita").value
  );
  const diaSemana = fechaSeleccionada.getDay();
  let errorHoraCita = evt.target.parentElement.querySelector(".error-message");

  // Si no existe un mensaje de error, lo creamos
  if (!errorHoraCita) {
    errorHoraCita = document.createElement("span");
    errorHoraCita.className = "error-message"; // Añadir clase para estilizar
    evt.target.parentElement.appendChild(errorHoraCita);
  }

  // Solo validamos si el día de la cita es de lunes a jueves (lunes = 1, martes = 2, ..., jueves = 4)
  if (diaSemana >= 1 && diaSemana <= 3) {
    // Lunes a Miércoles
    if (horaEnMinminutoutos >= 600 && horaEnMinutos <= 855) {
      // Entre 10:00 y 14:15
      errorHoraCita.textContent = ""; // Borrar mensaje de error
      inputHoraCita.setCustomValidity(""); // Validación correcta
    } else {
      errorHoraCita.textContent =
        "La hora debe estar entre las 10:00 y las 14:15.";
      inputHoraCita.setCustomValidity("Invalid"); // Marcar el campo como inválido
    }
  } else if (diaSemana === 4) {
    // Jueves
    if (horaEnMinutos >= 1110 && horaEnMinutos <= 1200) {
      // Entre 18:30 y 20:00
      errorHoraCita.textContent = ""; // Borrar mensaje de error
      inputHoraCita.setCustomValidity(""); // Validación correcta
    } else {
      errorHoraCita.textContent =
        "La hora debe estar entre las 18:30 y las 20:00.";
      inputHoraCita.setCustomValidity("Invalid"); // Marcar el campo como inválido
    }
  } else {
    errorHoraCita.textContent = ""; // Limpiar mensaje si día no es válido aún
    inputHoraCita.setCustomValidity("");
  }
}
