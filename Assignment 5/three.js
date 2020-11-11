function isValid(str) {
    if (str.length <= 1)
      return false
  
    let bracketOpen, currentBracket
    let stack = []
  
    let openBrackets = ['[', '{', '(']
    let closeBrackets = [']', '}', ')']
    //Open and closing mapped to each other

    for (let i = 0; i < str.length; i++) {
        currentBracket = str[i]
        //Reading the current char 

        //Match the closing bracket with open bracket
        //If not found return false
        if (closeBrackets.indexOf(currentBracket) != -1) {
            bracketOpen = openBrackets[closeBrackets.indexOf(currentBracket)]
            if (stack.length == 0 || (stack.pop() != bracketOpen)) return false
        } 
        //If open bracket then push into stack
        else {
            stack.push(currentBracket)
        }
    }
    return (stack.length == 0)
};

function isValidFun() {
    let str = document.getElementById("string").value

    if (str.length <= 1)
      return false
  
    let bracketOpen, currentBracket
    let stack = []
  
    let openBrackets = ['[', '{', '(']
    let closeBrackets = [']', '}', ')']
    //Open and closing mapped to each other

    for (let i = 0; i < str.length; i++) {
        currentBracket = str[i]
        //Reading the current char 

        //Match the closing bracket with open bracket
        //If not found return false
        if (closeBrackets.indexOf(currentBracket) != -1) {
            bracketOpen = openBrackets[closeBrackets.indexOf(currentBracket)]
            if (stack.length == 0 || (stack.pop() != bracketOpen)) return false
        } 
        //If open bracket then push into stack
        else {
            stack.push(currentBracket)
        }
    }
    ans = ""
    if(stack == undefined || stack.length < 1 ){
        ans += "Balanced";
    }
    else{
        ans += "Not Balanced";
    }
    alert(ans);
};


//Input 
//console.log(isValid("[["))