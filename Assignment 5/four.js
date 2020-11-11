//Logic for printing tree
function christmasTreelocal(height_of_tree){
    for (let i = 0; i < height_of_tree; i++) { 
        let str = ''; 
        for (let j = 1; j < height_of_tree-i; j++){ 
            str = str + ' '; 
        } 
        for (let k = 1; k <= (2*i+1); k++){ 
            if(i == 0) str = str + '*';
            else str = str + '0'; 
        } 
        console.log(str); 
    } 
}

function christmasTree(){
    var height_of_tree = document.getElementById("string").value;
    let finaltree = "";
    for (let i = 0; i < height_of_tree; i++) { 
        let str = ''; 
        for (let j = 1; j < height_of_tree-i; j++){ 
            str = str + "&nbsp" + "&nbsp"; 
        } 
        for (let k = 1; k <= (2*i+1); k++){ 
            if(i == 0) str = str + '*';
            else str = str + '0'; 
        } 
        finaltree += str +"<BR>";
    } 
    //var h1 = document.createElement('h1');
    document.getElementById("p").innerHTML = finaltree;
    //document.body.appendChild(h1);
}

// Run using node

let height_of_tree = 10;
christmasTreelocal(height_of_tree)
