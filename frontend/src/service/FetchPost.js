import CustomFetch from "./CustomFetch";

class FetchPost extends CustomFetch {

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

    return this.executaFetch(url, request);
  };

}

export default FetchPost;