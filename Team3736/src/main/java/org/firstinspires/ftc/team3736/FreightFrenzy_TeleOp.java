package org.firstinspires.ftc.team3736;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.library.Robot_Control;

@TeleOp(name = "Freight Frenzy TeleOp", group = "TeleOp")
//@Disabled
public class FreightFrenzy_TeleOp extends LinearOpMode {

    final FreightFrenzy_Hardware robot = new FreightFrenzy_Hardware();
    final Robot_Control control = new Robot_Control();
    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        //Get Hardware
        robot.init(hardwareMap);

        //Telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //START
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            control.basic(robot.leftDrive, robot.rightDrive, gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.a);

            //Telemetry
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            idle();
        }
    }
}