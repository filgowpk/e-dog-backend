# E-dog-backend

This is a simple REST API for managing dog breeds. Application is deployed on Render and can be accessed [here](https://e-dog-backend.onrender.com/swagger-ui.html).

## Available endpoints

### Dogs

- **`GET /api/v1/dog`**: Retrieve a paginated summary list of all dogs with optional sorting and filtering. 
Sorting, pagination and filtering should be passed as query parameters.
- **`GET /api/v1/dog/detailed`**: Retrieve a paginated detailed list of all dogs with optional sorting and filtering.  
Sorting, pagination and filtering should be passed as query parameters.
- **`GET /api/v1/dog/{breed}`**: Retrieve a dog by breed.
- **`POST /api/v1/dog`**: Add a new dog.
- **`PUT /api/v1/dog`**: Update a dog by breed.
- **`DELETE /api/v1/dog/{breed}`**: Delete a dog by breed.
- **`DELETE /api/v1/dog`**: Delete all dogs.

### Healthcheck

- **`GET /actuator/health`**
- **`GET /actuator/info`**

### Swagger
- **`GET /swagger-ui.html`**
- **`GET /v3/api-docs`**

### Security
- **`POST /api/v1/auth/login`**: Get Bearer token for authentication.
- **`POST /api/v1/auth/register`**: Register a new user.
