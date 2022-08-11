<template>
    <div>
        <form @submit.prevent="createUser">
            <div>
                <label for="email">Email</label>
                <input type="text" id="email" v-model="formData.email">
            </div>
            <div>
                <label for="password">Password</label>
                <input type="text" id="password" v-model="formData.password">
            </div>
            <div>
                <label for="role">Role</label>
                <input type="text" id="role" v-model="formData.role">
            </div>
            <button>Create User</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'createUser',
    data() {
        return {
            formData: {
                email: '',
                password: '',
                role: ''
            }

        }
    },
    methods: {
        createUser() {
            axios.post('http://localhost:8080/users', this.formData)
                .then(response => console.log(response))
                .catch(error => console.log(error))
        }
    }
}
</script>

<style scoped>
</style>