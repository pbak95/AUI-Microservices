const app = new Vue({
    el: "#app",
    data: {
        dateObj: {
            serviceName: null,
            date: null
        },
        hasher: {
            responsePresent: false,
            hasherInput: null,
            hasherResponse: null
        },
        userObj: {
            users: [],
            userIdInput: null,
            responsePresent: false,
            userDetails: null,
        },
        dateObjMock: {
            serviceName: null,
            date: "02.06.2018 12:29"
        },
        hasherMock: {
            responsePresent: true,
            hasherInput: null,
            hasherResponse: "asdasdasd1132sdasdasd"
        },
        userObjMock: {
            users: [],
            userIdInput: null,
            responsePresent: true,
            userDetails: {
                id: "3",
                username: "test",
                name: "test name",
                bio: "test bio"
            },
        }
    },
    methods: {
        md5Hash(hasherInput) {
            fetch("http://dp9grg7o4cfej.cloudfront.net/md5/" + hasherInput, {
                headers: {
                    "Content-Type": "text/plain",
                },
            })
                .then((response) => {
					var temp = Promise.resolve(response.text());
					var promiseB = temp.then(result => {
						console.log(result);
						this.hasher.hasherResponse = result;
						return result;
					});
                    this.hasher.responsePresent = true;
                    console.log(response);
                })
        },
        getUsers() {
            fetch("http://dp9grg7o4cfej.cloudfront.net/users", {
                headers: {
                    "Content-Type": "text/plain",
                },
            })
                .then(response => response.json())
                .then((data) => {
                    this.users = data.msg;
                    console.log(data);
                })
        },
        getUserDetail(userIdInput) {
            fetch("http://dp9grg7o4cfej.cloudfront.net/users/" + userIdInput, {
                headers: {
                    "Content-Type": "text/plain",
                },
            })
                .then(response => response.json())
                .then((data) => {
                    this.userObj.userDetails = data.msg;
                    this.userObj.responsePresent = true;
                    console.log(data);
                });

        }
    },
    mounted() {
        fetch("http://dp9grg7o4cfej.cloudfront.net/date")
            .then(response => response.json())
            .then((data) => {
                this.dateObj = data;
            })
    },
    template: `
    <div class="main-container">
        <div class="header-container">    
            <span>Date: {{dateObj.date}}</span>
        </div>
        <div class="section-container form-group">
             <label for="hasherInput">Value to be hashed:</label>
             <div class="input-group">
                 <input v-model="hasher.hasherInput" class="form-control" id="hasherInput"/>
                 <span class="input-group-btn">
                    <button v-on:click="md5Hash(hasher.hasherInput)"  class="btn btn-primary">Hash</button>
                 </span>
             </div>
             <div class="response">
                 <div v-if="hasher.responsePresent === true">
                    <span>Hasher response: {{hasher.hasherResponse}}</span>
                 </div>
             </div>
        </div>
        <div class="section-container form-group">   
            <label for="userInput">User ID:</label>
            <div class="input-group">
                <input v-model="userObj.userIdInput" class="form-control" id="userInput"/> 
                <span class="input-group-btn">
                    <button v-on:click="getUserDetail(userObj.userIdInput)"  class="btn btn-primary">User details</button>
                </span>
            </div>
            <div class="response">
                <li v-if="userObj.responsePresent === true">
                    <div>Username: {{userObj.userDetails.username}}</div>
                    <div>Full name: {{userObj.userDetails.name}}</div>
                    <div>Bio: {{userObj.userDetails.bio}}</div>
                </li>
            </div>
        </div>
    </div>
    `,
});
