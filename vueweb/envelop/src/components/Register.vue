<template>
    <div id="loginForm">
        <el-container>
            <el-main>
                <img src="../assets/logo.png" />
                <el-card class="box-card">
                    <el-form :label-position="labelPosition" :rules="rules" label-width="80px" :model="formLabelAlign" ref="formLabelAlign">
                        <el-form-item
                                label="用户名"
                                prop="name"
                        >
                            <el-input v-model="formLabelAlign.name"></el-input>
                        </el-form-item>
                        <el-form-item
                                label="密码"
                                prop="password"
                        >
                            <el-input type="password" v-model="formLabelAlign.password"></el-input>
                        </el-form-item>
                        <el-form-item
                                label="年龄"
                                prop="age"
                        >
                                <el-input type="number" v-model="formLabelAlign.age"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <div style="text-align: right">已有账户？<router-link to="/login">登陆</router-link></div>
                        </el-form-item>
                        <el-form-item>
                            <el-button-group style="width:100%">
                                <el-button style="width:100%" type="primary" @click="onSubmit('formLabelAlign')">注册</el-button>
                            </el-button-group>
                        </el-form-item>
                    </el-form>
                </el-card>
            </el-main>
        </el-container>
    </div>
</template>

<script>

    export default {
        name: 'login',
        components: {

        },
        data() {
            return {
                labelPosition: 'left',
                formLabelAlign: {
                    name: '',
                    password: '',
                    age:""
                },
                rules: {
                    name: [
                        { required: true, message: '请输入名称', trigger: 'blur' },
                        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    password:[
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ],
                    age:[
                        { required: true, message: '请输入年龄', trigger: 'blur' },
                    ]
                }
            };
        },
        methods: {
            onSubmit(formName) {
                let that = this
                console.log(formName);
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(valid,this.$data.formLabelAlign);
                        let url="http://localhost:9090/save"
                        fetch(url, {
                            method: 'POST', // or 'PUT'
                            body: JSON.stringify(that.$data.formLabelAlign), // data can be `string` or {object}!
                            headers: new Headers({
                                'Content-Type': 'application/json'
                            })
                        }).then(res => res.json())
                            .catch(error => console.error('Error:', error))
                            .then(response =>{
                                console.log('Success:', response)
                                if(response.data.code=="10"){
                                    that.$message({
                                        message: '恭喜你，注册成功',
                                        type: 'success'
                                    });
                                    that.$router.push({ path: '/login' })
                                }
                            } );
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    }
</script>

<style>
    #loginForm{}
    .el-main {
        margin-top: 100px;
    }
    .box-card{
        width:500px;
        margin:20px auto;
        background: rgba(255,255,255,0.5) !important;
        border:0px solid !important;
    }
</style>
