import java.util.Date
import java.text.SimpleDateFormat
pipeline {
   agent any
   stages {
      stage('Hello') {
         steps {
			  script{
				String date =new SimpleDateFormat("dd-MM-yyyy").format(new Date())
				println "Hola Mundo! El día de hoy es "+ elDia +".\r\n Este curso me hizo programar mas de lo que me hubiese gustado"
			  }
         }
      }
   }
}

