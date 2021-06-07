import React, { Component } from 'react';
import { connect } from 'react-redux';
import {bindActionCreators} from 'redux';
import * as baseActions from 'redux/modules/base';

class Main extends Component{
    componentWillMount() {
        this.props.BaseActions.setHeaderVisibility(false);
    }

    componentWillUnmount() {
        this.props.BaseActions.setHeaderVisibility(true);
    }
    render() {
        return (
            <AuthWrapper>

            </AuthWrapper>
        );
    }
}
export default connect(
    (state) => ({

    }),
    (dispatch) => ({
        BaseActions: bindActionCreators(baseActions, dispatch)
    })
)(Main);