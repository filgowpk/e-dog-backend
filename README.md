# E-dog-backend

This is a simple REST API for managing dog breeds. Application is deployed on Render and can be accessed [here](https://e-dog-backend.onrender.com/swagger-ui.html).

## Table of contents


## Technologies
- Java 17
- Spring Boot 3.3.5
- Docker
- MongoDB
- Swagger
- Render (for deployment)

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

### List settings parameters

For the `GET /api/v1/dog` and `GET /api/v1/dog/detailed` endpoints, the following parameters can be used for sorting, 
pagination and filtering (provided as query parameters):

#### Pagination and sorting

- **`limit`**: Maximum number of records to return.
- **`offset`**: Number of records to skip.
- **`sortBy`**: Field to sort by.
- **`sortDesc`**: Sort in descending order if true.

#### Filtering

- **`colors`**: List of colors to filter by.
- **`characteristics`**: List of characteristics to filter by.
- **`originCountry`**: Filter by the country of origin.
- **`breedingDifficulty`**: Filter by breeding difficulty.
- **`activityLevel`**: Filter by activity level.
- **`sheddingLevel`**: Filter by shedding level.
- **`spaceNeeds`**: Filter by space needs.
- **`groomingNeeds`**: Filter by grooming needs.
- **`healthIssues`**: Filter by health issues.
- **`trainability`**: Filter by trainability.
- **`goodWithChildren`**: Filter by whether the dog is good with children.
- **`goodWithOtherPets`**: Filter by whether the dog is good with other pets.
- **`hypoallergenic`**: Filter by whether the dog is hypoallergenic.

### Healthcheck

- **`GET /actuator/health`**
- **`GET /actuator/info`**

### Swagger
- **`GET /swagger-ui/index.html`**
- **`GET /v3/api-docs`**

### Security
- **`POST /api/v1/auth/login`**: Get Bearer token for authentication.
- **[SUSPENDED]** **`POST /api/v1/auth/register`**: Register a new user.
