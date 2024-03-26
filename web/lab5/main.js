
// board
var blockSize = 25;
var rows = 20;
var cols = 20;
var board;
var context;

// snake head
var snakeX = blockSize * 5;
var snakeY = blockSize * 5;
var snakeBody = [];

// snake speed
var speedX = 0;
var speedY = 0;

//food
var foodX;
var foodY;

var gameOver = false;

// draw board
window.onload = function () {
    board = document.getElementById("board");
    board.height = rows * blockSize;
    board.width = cols * blockSize;
    context = board.getContext("2d");

    placeFood();
    document.addEventListener("keyup", changeDirection);

    // uptade();
    setInterval(update, 1000/10);
}

function update() {

    if(gameOver){
        return;
    }

    // draw board
    for (var row = 0; row < rows; row++) {
        for (var col = 0; col < cols; col++) {
            if((row+col)%2 == 0){
                context.fillStyle = "mediumSeaGreen";
            }
            else{
                context.fillStyle = "Green";
            }
            context.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
        }
    }

    //Draw food
    context.fillStyle = "red";
    context.fillRect(foodX, foodY, blockSize, blockSize);

    if(snakeX == foodX && snakeY == foodY){
        snakeBody.push([foodX, foodY]);
        placeFood();
    }
    // Draw snake head
    context.fillStyle = "blue";
    snakeX += speedX * blockSize;
    snakeY += speedY * blockSize;
    context.fillRect(snakeX, snakeY, blockSize, blockSize);

    for(let i = 0; i < snakeBody.length; i++){
        context.fillRect(snakeBody[i][0],snakeBody[i][1],blockSize,blockSize);
    }

    for(let i = snakeBody.length-1; i > 0; i--){
        snakeBody[i] = snakeBody[i-1];
    }
    if(snakeBody.length){
        snakeBody[0] = [snakeX,snakeY];
    }

    // gameOver
    if(snakeX < 0 || snakeX > cols*blockSize || snakeY < 0 || snakeY > rows*blockSize){
        gameOver = true;
        alert("Game Over");
    }
    
    for(let i = 0; i < snakeBody.length; i++){
        if(snakeX == snakeBody[i][0] && snakeY == snakeBody[i][1]){
            gameOver = true;
            alert("Game Over");
        }
    }
}

function changeDirection(e){
    if(e.code == "ArrowUp" && speedY != 1){
        speedX = 0;
        speedY = -1;
    }
    else if(e.code == "ArrowDown" && speedY != -1){
        speedX = 0;
        speedY = 1;
    }
    else if(e.code == "ArrowLeft" && speedX != 1){
        speedX = -1;
        speedY = 0;
    }
    else if(e.code == "ArrowRight" && speedX != -1){
        speedX = 1;
        speedY = 0;
    }
}

function placeFood(){
    foodX = Math.floor(Math.random() * cols) * blockSize;
    foodY = Math.floor(Math.random() * rows) * blockSize;
}
