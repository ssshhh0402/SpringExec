import React, {Component} from 'react';
import {bindActionCreators} from 'redux';
import { connect } from 'react-redux';
import * as mainActions from '../../redux/modules/main';
import { MainContent } from '../../components/Main';

class MainPage extends Component{
    constructor(props){
        super(props);
        this.handleGetRooms();
    }
    
    // componentDidMount(){
    //     console.log("didmount")
    //     const { MainActions} = this.props;

    //     MainActions.GETROOMS();
    // }
    componentWillUnmount() {
        const { MainActions } = this.props;
        // MainActions.initializeForm('rooms')
    }
    
    setError = (message) => {
        const { MainActions } = this.props;
        MainActions.setError({
            form: 'rooms',
            message
        });
        return false;
    }
    handleGetRooms = async () => {
        const {MainActions} = this.props;
        try{
            await MainActions.GETROOMS();
        }catch(e){
            alert(e);
        }
    }
    render(){
        console.log('render')
        const datas = this.props.result.toJS().data;
        var items = "";
        if(datas != undefined){
            items = datas.map((item) => {
                return(
                    <div>
                        <h1>{item.title}</h1>
                        <h1>{item.url}</h1>
                    </div>
                )
            })
        }
        return(
            <MainContent title="MainPage">
                {items}
            </MainContent>
        )
    }
}
export default connect(
    (state) => ({
        form: state.main.getIn(['rooms', 'form']),
        error: state.main.getIn(['login', 'error']),
        result: state.main.get('result')
    }),
    (dispatch) => ({
        MainActions: bindActionCreators(mainActions, dispatch),
        //UserActions: bindActionCreators(userActions, dispatch)
    })
)(MainPage);