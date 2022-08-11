<template>
    <div>
        <button @click="getUsers">Get Users</button>
        <div v-for="user in users" :key="user.email">
            <h3>{{user.email}}</h3>
            <p>{{user.password}}</p>
            <p>{{user.role}}</p>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'getUsers',
    data() {
        return {
            users: [],
        }
    },
    methods: {
        getUsers() {
            axios.get('http://localhost:8080/users')
                .then((response) => {
                    console.log(response.data)
                    this.users = response.data
                })
                .catch((error) => console.log(error))
        }
    }

}
</script>

<style scoped>
</style>