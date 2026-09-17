//mostrar información por consola("Devuelves al usuario")
//enteros:
console.log(1);
console.log(21);
console.log(-16);
//decimales:
console.log(3.14);
console.log(1.6);
console.log(-5.89);
//string con comillas dobles:
console.log("Hola Fosela");
//string con comillas simples:
console.log('Hola Fosela');
//objetos:
console.log({
    nombre: "Fosela", 
    edad: 21, 
    profesion: "Desarrollador"
});
//symbol:
Symbol('mySymbol');
//bigInt:
123456789012345678901234567890n;

//llamada a las variable vacía
let age;
consolelog(age);//undefined
//asignación de valores
age = 19;
console.log(age);//devolverá 19
//reasiganción de valores
age = 100;
console.log(age);//devuelve 100
age = 19;
console.log(age);//devuelve 19 y el valor que se guarda a partir de aqui es 19
//reglas de declaraciones
// Bad variable names
let x = 10;
let y = "John";
// Good variable names
let age = 10;
let nombre = "Fosela";
// nombres de variables válidos(deben empezar co una letra, un guión bajo o un dolar)
let age;
let _score;
let $total;
// nombre de variabeles invalidos
 // let 1stPlace; <---empieza con un número
//sensibilidad a las mayusculas

let age = 25;
let Age = 19;
console.log(age);//devuelve 25
console.log(Age);//devuelve 19
//camelCase:
let thisIsACamelCase;
let anotherExampleVariable;
let freeCodeCampStudent;
//constantes:
const maxScore = 100;
console.log(maxScore);
//si intentamos redefinirlo
maxScore = 200;//nos dará error
//podemos declarar variables vacias y luego. asignarles un valor
let age;
console.log(age);//undefined
age = 19;
console.log(age);//nos devolverá 19
//pero no modemos declara constantes vacías
const age;//Error: Missing initializer in const declaration

//string en JS
//comillado simple
let comillasSimples = 'Esto es un string';
console.log(comillasSimples);
//comillado doble
let comillasDobles = "Esto tambien es un string";
console.log(comillasDobles);
//solo puedes coger o comillas simples o dobles pero no las dos
const error = "esto es un error";
//inmutabilidad de los string
//asignación de una nueva cadena a la variable developer
let developer = 'Pablo';
consolelog(developer);
developer = "Fosela";
console.log(developer);
//concatenación de strings
// concatenar con el operador +
let firstName = "Juan";
let lastName = 'Carlos';
let fullName = firstName + "" + lastName;
console.log(fullName);//devuelve Juan Carlos
//tener cuidado con los problemas de espacio
let firstName = "Juan";
let lastName = 'Carlos';
let fullName = firstName + lastName;
console.log(fullName);//devuelve JuanCarlos
//anexar cadenas con +=
let saludo = "Hola";
consolelog(saludo);//devuelve solo hola
saludo += ', Fosela';
consolelog(saludo);//ahora si que devuelve el saludo completo
//es importante recordar que las cadenas son inmutables, una vez que las crees no se
//pueden alterar
//método concat()
let string1 = 'Hola';
let string2 = 'Fosela';
//string separados
let resultado = string1.concat('' + string2);
console.log(result);//devuelve Hola Fosela

//console.log()
console.log("Hola mundo");//imprime hola mundop en la consola
let num = 5;
console.log(num);//imprime el valor que le hemos dado a la variable num(5)
let nombre = 'Fosela';
console.log("Hola, " + nombre +"!");//Hola, Fosela!
console.log("Nombre: " + nombre + ". Edad: " + num);//Nombre: Fosela. Edad: 5
//util para imprimir variables o constantes a la vez

//puntos y comas, para terminar una sentencia en JS

let variableOne = 5;  // Declara una variable y le asigna un valor
let variableTwo = 10; // Declara otra variable y le asigna otro valor

//ejemplo de los comentarios
// This is to allow English to build without having to download the i18n files.
// It fails when trying to resolve the i18n-curriculum path if they don't exist.
const curriculumLocale = process.env.CURRICULUM_LOCALE ?? 'english';
const I18N_CURRICULUM_DIR = path.resolve(
  __dirname,
  curriculumLocale === 'english' ? '.' : 'i18n-curriculum/curriculum'
);
//los comentarios en bloque 
/* Since there can be more than one way to complete a certification (using the
legacy curriculum or the new one, for instance), we need a certification
field to track which certification this belongs to. */
const dupeCertifications = [
  {
    certification: 'responsive-web-design',
    dupe: '2022/responsive-web-design'
  }
];
const hasDupe = dupeCertifications.find(
  cert => cert.dupe === meta.superBlock
);
//evitar sobrecomentar como:
// This code uses the const keyword to create a new variable called price.
// We are assigning the number 10 to the price variable.
const price = 10;