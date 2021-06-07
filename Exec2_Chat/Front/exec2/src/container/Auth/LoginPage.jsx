import React, {Component} from 'react';
import {bindActionCreators} from 'redux';
import { connect } from 'react-redux';
import { AuthContent, InputLabel, AuthButton, RightAlignedItem, AuthError } from '../../components/Auth';
// import * as userActions from 'redux/modules/user';
//import storage from '../../lib/storage';
import * as authActions from '../../redux/modules/auth';

class LoginPage extends Component{
    
    componentWillUnmount() {
        const { AuthActions } = this.props;
        AuthActions.initializeForm('login')
    }
    handleChange = (e) => {
        const { AuthActions } = this.props;
        const { name, value } = e.target;

        AuthActions.changeInput({
            name,
            value,
            form: 'login'
        });
    }
    setError = (message) => {
        const { AuthActions } = this.props;
        AuthActions.setError({
            form: 'login',
            message
        });
        return false;
    }

    handleLocalLogin = async () => {
        const { form, AuthActions, UserActions, history } = this.props;
        const { email, password } = form.toJS();

        try {
            await AuthActions.localLogin({email, password});
            const loggedInfo = this.props.result.toJS();

            //UserActions.setLoggedInfo(loggedInfo);
            console.log(loggedInfo);
            history.push('/main');
            //storage.set('loggedInfo', loggedInfo);

        } catch (e) {
            alert(e);
            this.setError('잘못된 계정정보입니다.');
        }
    }
    
    
    render(){
        const { email, password } = this.props.form.toJS(); // form 에서 email 과 password 값을 읽어옴
        const { handleChange, handleLocalLogin } = this;
        const { error } = this.props;

        return(
            <AuthContent title="로그인">
                <InputLabel 
                    label="이메일" 
                    name="email" 
                    placeholder="이메일" 
                    value={email} 
                    onChange={handleChange}
                />
                <InputLabel 
                    label="비밀번호" 
                    name="password" 
                    placeholder="비밀번호" 
                    type="password" 
                    value={password} 
                    onChange={handleChange}
                />
                {
                    error && <AuthError>{error}</AuthError>
                }
                <AuthButton onClick={handleLocalLogin}>로그인</AuthButton>
                <RightAlignedItem to="/auth/register">회원가입</RightAlignedItem>
            </AuthContent>
        )
    }
}
export default connect(
    (state) => ({
        form: state.auth.getIn(['login', 'form']),
        error: state.auth.getIn(['login', 'error']),
        result: state.auth.get('result')
    }),
    (dispatch) => ({
        AuthActions: bindActionCreators(authActions, dispatch),
        //UserActions: bindActionCreators(userActions, dispatch)
    })
)(LoginPage);