

int led2=2; //SALA
int led3=3; //DORMITORIO
int led4=4; //SENSOR DE LUZ
int led5=5; //COCINA
int led6=6; //GARAGE
int spir7=7; //SENSOR DE MOVIMIENTO
int buzz8=8; //zumbador 
int pir_lectura;
int pir_estado = LOW;


char estado;

void setup(){
  
  Serial1.begin(9600);
  pinMode(led2,OUTPUT); //LED SALA
  pinMode(led3,OUTPUT); //LED DORMITORIO
  //pinMode(led4,OUTPUT); //SENSOR DE LUZ
  pinMode(led5,OUTPUT); //LED COCINA
  pinMode(led6,OUTPUT); //LED GARAGE
  pinMode(buzz8,OUTPUT); //SENSOR DE MOVIMIENTO
  pinMode(spir7,INPUT); //ZUMBADOR
  
}

void loop(){
    if( Serial1.available()>0){
    
        estado = Serial1.read();

//SALA

    if (estado =='a'){
        digitalWrite(led2,HIGH);
    }
    
    if(estado=='b'){
        digitalWrite(led2,LOW);
    }
//SALA



//DORMITORIO

    if (estado =='c'){
        digitalWrite(led3,HIGH);
    }
    
    if(estado=='d'){
        digitalWrite(led3,LOW);
    }
//DORMITORIO




//CENSOR DE LUZ

    if (estado =='e'){
        digitalWrite(led4,HIGH);
    }
    
    if(estado=='f'){
        digitalWrite(led4,LOW);
    }
//CENSOR DE LUZ




//COCINA
    if (estado =='g'){
        digitalWrite(led5,HIGH);
    }
    
    if(estado=='h'){
        digitalWrite(led5,LOW);
    }

    
//COCINA        
    
    
   

//GARAGE

    if (estado =='i'){
        digitalWrite(led6,HIGH);
    }
    
    if(estado=='j'){
        digitalWrite(led6,LOW);
    }


//GARAGE



}




//SENSOR DE LUZ


    if (estado =='k'){

        //digitalWrite(spir7,HIGH);

        pir_lectura = digitalRead(spir7);
        
        if(pir_lectura == HIGH){

          digitalWrite(buzz8, HIGH);
          //tonos();
          delay(1000);
          }
         if(pir_estado == LOW){

           pir_estado=HIGH;
            
          }else{
            digitalWrite(buzz8, LOW);  
            }

          
    }
    
    if(estado=='l'){
        
    }

  
//SENSOR DE LUZ


}


void tonos(){
  tone(buzz8,8.18); // C | octava - 2;
  delay(150);
  tone(buzz8,9.72); // D# | octava - 2;
  delay(150);
  tone(buzz8,14.57); // A# | octava - 2;
  delay(150);
  noTone(buzz8);
  delay(1000);
  
  tone(buzz8,13.75); // A | octava - 2;
  delay(150);
  tone(buzz8,9.72); // D# | octava - 2;
  delay(150);
  tone(buzz8,8.18); // C | octava - 2;
  delay(150);
  noTone(buzz8);
  delay(1000);     
}
