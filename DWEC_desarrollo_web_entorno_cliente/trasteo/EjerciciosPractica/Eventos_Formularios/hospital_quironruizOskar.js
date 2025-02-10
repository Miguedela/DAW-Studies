let SEGUROS_MEDICOS = [
    {value: 1, texto: 'Adeslas'},
    {value: 2, texto: 'Asisa'},
    {value: 3, texto: 'Caser Salud'},
    {value: 4, texto: 'DKV'},
    {value: 5, texto: 'Mapfre'},
    {value: 6, texto: 'Sanitas'}
];

// Escribe aquí tu código
let inpNombre = document.getElementById("inputNombre");
inpNombre.setAttribute("required","required");

let inpApellido = document.getElementById("inputApellidos");
inpApellido.setAttribute("required","required");

document.querySelector('[name = "miformulario"]').addEventListener("submit",dni);
// document.getElementById("miformulario").addEventListener("submit",dni);
function dni(evt) {
    evt.preventDefault();
    
    const inpDni = document.getElementById("inputDNI");
    const dniError = document.getElementById("dniError");
    dniError.style.color = "red";

    const patronDni = /^\d{8}[trwagmyfpdxbnjzsqvhlcke]$/i;

    if(!patronDni.test(inpDni.value)){
        dniError.innerHTML = "Formato de DNI no valido";
    }else{
        dniError.innerHTML ="";
    }



    if (patronDni.test(inpDni.value)) {
        if (comprobarletra(inpDni.value)) {
            dniError.innerHTML = "";
        }else{
            dniError.innerHTML = "Letra no valida";
        }
    }
    
}

function comprobarletra(dni) {
    let numDni = parseInt(dni.substring(0,dni.length-1));
    let letraDni = dni.substring(dni.length-1).toLowerCase();

    let indice = numDni % 23;
    const letrasDNI = ['t', 'r', 'w', 'a', 'g', 'm', 'y', 'f', 'p', 'd', 'x', 'b', 'n', 'j', 'z', 's', 'q', 'v', 'h', 'l', 'c', 'k', 'e'];

    if (letrasDNI[indice]==letraDni) {
        return true;
    }else{
        return false;
    }
}

// Poblar de manera dinámica el desplegable seguro médico con los datos que se muestran a
//  continuación (los datos los tienes disponibles en el fichero .js).
//  El seguro médico es un campo obligatorio de rellenar.

let inpSeguroMedico = document.getElementById("inputSeguroMedico");
inpSeguroMedico.setAttribute("required","required");

let select = document.getElementById("inputSeguroMedico");
let optionCode="";

for (let i = 0; i < SEGUROS_MEDICOS.length; i++) {
    optionCode+= `<option value='${SEGUROS_MEDICOS[i].texto}'>${SEGUROS_MEDICOS[i].texto}</option>`;        
}
select.innerHTML = optionCode;


// Para seleccionar el médico el usuario podrá elegir entre "Médico de familia" o "Especialista".
// Si selecciona "Especialista" debe habilitarse el desplegable que permite seleccionar la especialidad
// y será obligatorio rellenarla. Si ha marcado "Médico de familia" la especialidad debe estar deshabilitada.

const radioMedicoFamilia = document.getElementById("inputMedicoFamilia");
const radioMedicoEspecialista = document.getElementById("inputMedicoEspecialista");
const selectEspecialidad = document.getElementById("inputEspecialidad");

function actualizarEspecialidad() {
    if (radioMedicoEspecialista.checked) {
        selectEspecialidad.disabled = false;
        selectEspecialidad.required = true;
    }else{
        selectEspecialidad.disabled = true;
        selectEspecialidad.required =false;
    }
}
radioMedicoEspecialista.addEventListener('change', actualizarEspecialidad);
radioMedicoFamilia.addEventListener('change', actualizarEspecialidad);


// La fecha de la cita será obligatorio de rellenar y sólo puede ser un día de lunes jueves (ambos inclusive). 
// Si el usuario elige un día fuera de ese rango se mostrará un error al usuario
// con el texto "El día de la cita sólo puede ser de lunes a jueves".

const inputFechaCita = document.getElementById("inputFechaCita");
const errorFechaCita = document.createElement("span"); // Crear un span para mostrar el error
errorFechaCita.style.color = "red"; // Estilo del error
inputFechaCita.insertAdjacentElement("afterend", errorFechaCita); // Insertar el span después del input

function validarFechaCita() {
    const fechaSeleccionada = new Date(inputFechaCita.value);
    const diaSemana = fechaSeleccionada.getDay(); // Obtiene el día de la semana (0 = domingo, 1 = lunes, etc.)

    // Validar si el día está entre lunes (1) y jueves (4)
    if (diaSemana >= 1 && diaSemana <= 4) {
        errorFechaCita.textContent = ""; // Borrar el mensaje de error
        inputFechaCita.setCustomValidity(""); // Validación correcta
    } else {
        errorFechaCita.textContent = "El día de la cita sólo puede ser de lunes a jueves.";
        inputFechaCita.setCustomValidity("Invalid"); // Marcar el campo como inválido
    }
}

// Escuchar cambios en el campo de fecha
inputFechaCita.addEventListener("input", validarFechaCita);



// La hora de la cita será obligatoria de rellenar y dependerá del día de la semana de la cita.
// Si el día de la cita es de lunes a miércoles la hora podrá estar comprendida entre las 10:00 y las 14:15. 
// Si el día de la semana es jueves la hora podrá estar en el rango 18:30 a 20:00. 
// Si no es válida la hora se mostrará al usuario el error pertinente.


const inputHoraCita = document.getElementById("inputHoraCita");
const errorHoraCita = document.createElement("span"); 
inputHoraCita.insertAdjacentElement("afterend",errorHoraCita);
// Estilizar los mensajes de error
errorHoraCita.style.color = "red";


// Función para validar la hora
function validarHoraCita() {
    const fechaSeleccionada = new Date(inputFechaCita.value);
    const diaSemana = fechaSeleccionada.getDay();
    const horaSeleccionada = inputHoraCita.value;

    if (!horaSeleccionada) {
        errorHoraCita.textContent = "La hora de la cita es obligatoria.";
        inputHoraCita.setCustomValidity("Invalid");
        return;
    }

    const hora = parseInt(horaSeleccionada.split(":")[0], 10); // Obtener la hora (parte antes del ":")
    const minuto = parseInt(horaSeleccionada.split(":")[1], 10); // Obtener los minutos (parte después del ":")
    const horaEnMinutos = hora * 60 + minuto; // Convertir la hora a minutos para comparaciones más fáciles

    if (diaSemana >= 1 && diaSemana <= 3) { // Lunes a Miércoles
        if (horaEnMinutos >= 600 && horaEnMinutos <= 855) { // Entre 10:00 y 14:15
            errorHoraCita.textContent = ""; // Borrar mensaje de error
            inputHoraCita.setCustomValidity(""); // Validación correcta
        } else {
            errorHoraCita.textContent = "La hora debe estar entre las 10:00 y las 14:15.";
            inputHoraCita.setCustomValidity("Invalid"); // Marcar el campo como inválido
        }
    } else if (diaSemana === 4) { // Jueves
        if (horaEnMinutos >= 1110 && horaEnMinutos <= 1200) { // Entre 18:30 y 20:00
            errorHoraCita.textContent = ""; // Borrar mensaje de error
            inputHoraCita.setCustomValidity(""); // Validación correcta
        } else {
            errorHoraCita.textContent = "La hora debe estar entre las 18:30 y las 20:00.";
            inputHoraCita.setCustomValidity("Invalid"); // Marcar el campo como inválido
        }
    } else {
        errorHoraCita.textContent = ""; // Limpiar mensaje si día no es válido aún
        inputHoraCita.setCustomValidity("");
    }
}


// Escuchar cambios en la hora
inputHoraCita.addEventListener("input", validarHoraCita);
