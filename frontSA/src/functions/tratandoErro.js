export function tratandoErro(error) {
    if (error.response) {
        // Request made and server responded
        const { status } = error.response;
        let errorMessage = "Error registering user";
        if (status === 400) {
          errorMessage = "ERRO: ESTES DADOS JÁ FORAM REGISTRADOS.";
        } else if (status === 401) {
          errorMessage = "Unauthorized. Please log in.";
        } else if (status === 403) {
          errorMessage = "Forbidden. You don't have permission to register a user.";
        } else if (status === 404) {
          errorMessage = "Not found. The requested resource could not be found.";
        } else if (status === 500) {
          errorMessage = "Internal server error. Please try again later.";
        }
        console.error(errorMessage, error);
        alert(errorMessage);
      } else if (error.request) {
        // The request was made but no response was received
        console.error("No response received from server", error.request);
        alert("No response received from server. Please try again later.");
      } else {
        // Something happened in setting up the request that triggered an Error
        console.error("Error", error.message);
        alert("Error: " + error.message);
      }
}