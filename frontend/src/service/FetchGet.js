import CustomFetch from "./CustomFetch";

class FetchGet extends CustomFetch {

  getHeader = () => {
    let header = new Headers();
    header.append("Access-Control-Allow-Origin", '*');

    return header;
  };

  getRequest = (header) => {
    return {
      method : 'GET',
      mode: 'cors',
      headers: header
    };
  };

  realizarRequest = (url) => {
    let request = this.getRequest(
      this.getHeader()
    );

    return this.executaFetch(url, request);
  };

}

export default FetchGet;