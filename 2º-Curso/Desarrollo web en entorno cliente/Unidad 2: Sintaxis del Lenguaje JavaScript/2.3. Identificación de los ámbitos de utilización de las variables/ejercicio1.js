for (var i = 0; i < 3; i++) { 
  setTimeout(function() { 
    console.log("Valor con var:", i); 
  }, 100); 
} 
 
for (let j = 0; j < 3; j++) { 
  setTimeout(function() { 
    console.log("Valor con let:", j); 
  }, 100); 
}