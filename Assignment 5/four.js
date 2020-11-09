//Logic for printing tree
function christmasTree(height_of_tree){
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

let height_of_tree = 10;


christmasTree(height_of_tree)