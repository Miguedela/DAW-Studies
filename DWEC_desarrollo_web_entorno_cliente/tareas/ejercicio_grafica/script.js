google.charts.load("current", { packages: ["corechart"] });
google.charts.setOnLoadCallback(drawChart);

const datos = [
  { tarea: "Jugar al lol", horas: 7 },
  { tarea: "Dormir", horas: 8 },
  { tarea: "Comer", horas: 6 },
  { tarea: "Programar", horas: 3 },
];

// metodo auxiliar que transforma mis datos
function generarArrayParaDataTable(datos) {
  const arrayDataTable = [["Tareas", "Horas por día"]];

  for (const item of datos) {
    arrayDataTable.push([item.tarea, item.horas]);
  }

  return arrayDataTable;
}

// genero el array de objetos
const arrayDataTable = generarArrayParaDataTable(datos);

// metodo para generar la tabla
function drawChart() {
  var data = google.visualization.arrayToDataTable(arrayDataTable);

  var options = {
    title: "Mis vacaciones de navidad",
    is3D: true,
  };

  var chart = new google.visualization.PieChart(
    document.getElementById("piechart_3d")
  );
  chart.draw(data, options);
}
