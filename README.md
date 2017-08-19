# Basic-Calculator


A simple calculator that evaluates expressions in a very simple integer expression language. The program takes an input on the command line, computes the result, and prints it to the console.

Operations supported - 
Add - addition 
Sub - subtraction 
Mult - multiplication 
Div - division 
let - takes three arguments 

Examples - 
add(4,5) 
Output -> 9

add(2,mult(2,3)) 
Output -> 8

mult(add(2,2), div(9,3)) 
Output -> 12

Setup

git clone https://github.com/vinaycn/Basic-Calculator.git
cd Basic-Calculator/
Build

mvn package
Running the application

Ruuning the application
java -cp ./target/basiccalculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.synopsys.basiccalculator.BasicCalculatorMain "add(2,3,mult(3,4))"







