class CustomFetch {
  isResponseOK = response => {
    return response.status === 200 || response.status === "SUCESSO";
  };

  executaFetch = (url, request) => {
    return new Promise((resolve, reject) => {
        fetch(url, request)
          .then(response => response.json())
          .then((response) => {
            if(this.isResponseOK(response)){
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
  }
}

export default CustomFetch;