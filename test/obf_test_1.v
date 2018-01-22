// ----------------------------------------------------------
// Module: nc_test_1
// ----------------------------------------------------------
module obf_test_1 
(
	// input ports
	i1,
	i2,
	// output ports
	o1,
	o2 
);
	
	// input ports
	input i1;
	input i2;
	
	// output ports
	output o1;
	output o2;


	assign o1 = i1 & i2;
	assign o2 = ^{i1,i2};
	 
endmodule // verilogtest_1

