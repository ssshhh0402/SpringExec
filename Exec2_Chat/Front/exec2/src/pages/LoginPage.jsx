import React, {Component} from 'react';
import InputLabel from './Auth/InputLabel'
import AuthWrapper from './Auth/AuthWrapper'
import AuthButton from './Auth/AuthButton'
import RightAlignedLink from './Auth/RightAlignedLink'
class LoginPage extends Component{
    render(){
        return(
            <AuthWrapper title="로그인">
                <InputLabel label="아이디" name="email" placeholder="이메일"/>
                <InputLabel label="비밀번호" name="password" placeholder="비밀번호"/>
                <AuthButton>로그인 </AuthButton>
                <RightAlignedLink to="./auth/register">회원가입</RightAlignedLink>
            </AuthWrapper>
        )
    }
}
export default LoginPage;