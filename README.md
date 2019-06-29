# word-gen
An API to generate random words using markov-chains.

### USAGE : 

A simple post call to the api with optional body params would generate the random words.
#### POST : <https://random-word-gen.herokuapp.com/generate>
##### form-data params:
wordLength : `NUMBER`, beginningWith : `TEXT`

#### Sample CURL command:
POST /generate HTTP/1.1
Host: random-word-gen.herokuapp.com
cache-control: no-cache
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
