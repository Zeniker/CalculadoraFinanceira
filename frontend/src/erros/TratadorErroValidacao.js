import PubSub from 'pubsub-js';

class TratadorErroValidacao {

  publicaErros(erros){
    erros.errors.forEach(e => {
      PubSub.publish("erro-validacao", e);
    });

  }

}

export default TratadorErroValidacao;