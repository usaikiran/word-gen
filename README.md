# word-gen
An API to generate random words using markov-chains.

### USAGE : 

A simple post call to the api with optional body params would generate the random words.
#### POST : <https://random-word-gen.herokuapp.com/generate>
##### form-data params:
wordLength : `NUMBER`<br /> beginningWith : `TEXT`

#### Sample CURL command:
POST /generate HTTP/1.1 <br />
Host: random-word-gen.herokuapp.com <br />
cache-control: no-cache <br />
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
