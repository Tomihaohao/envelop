<template>
    <div id="loginForm">
        <el-container>
            <el-main>
                <img src="../assets/logo.png" />
                <el-card class="box-card">
                    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign" ref="formLabelAlign">
                        <el-form-item
                                label="用户名"
                                :rules="[
                                  { required: true, message: '用户名不能为空',trigger: 'blur'},
                                ]"
                        >
                            <el-input v-model="formLabelAlign.name"></el-input>
                        </el-form-item>
                        <el-form-item
                                label="密码"
                                :rules="[
                                  { required: true, message: '密码不能为空'},
                                ]"
                        >
                            <el-input type="password" v-model="formLabelAlign.password"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <div style="text-align: right">没有账户？<router-link to="/register">创建一个</router-link></div>
                        </el-form-item>
                        <el-form-item>
                            <el-button-group style="width:100%">
                                <el-button style="width:100%" type="primary" @click="onSubmit('formLabelAlign')">登陆</el-button>
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
                }
            };
        },
        methods: {
            onSubmit(formName) {
                console.log(formName);
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(valid);

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
