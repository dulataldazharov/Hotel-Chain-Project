import React from 'react';
import {
	BrowserRouter as Router,
	Switch,
	Route,
} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import { Home, NavBar, RegistrationPage } from './components';

function App() {
	return (
		<Router>

			<NavBar />

			<Switch>
				<Route path='/' exact component={Home} />
				<Route path='/register' component={RegistrationPage} />
			</Switch>

			{/* TODO Footer */}

		</Router>
	);
}

export default App;
