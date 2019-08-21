class FetchPost {

  getHeader = () => {
    let header = new Headers();
    header.append("Access-Control-Allow-Origin", '*');
    header.append("Content-Type", 'application/json');

    return header;
  };

  getRequest = (header, corpoRequisicao) => {
     return {
      method : 'POST',
      mode: 'cors',
      body: JSON.stringify(corpoRequisicao),
      headers: header
    };
  };

  realizarRequest = (url, dados) => {
    let request = this.getRequest(
      this.getHeader(),
      dados
    );

    return new Promise((resolve, reject) => {
        fetch(url, request)
          .then(response => response.json())
          .then((response) => {
            if(response.status === 200){
              resolve(response);
            }else{
              reject(response);
            }
          })
          .catch(error => {
            reject(error);
          });
    }
    );
  };

}

export default FetchPost;