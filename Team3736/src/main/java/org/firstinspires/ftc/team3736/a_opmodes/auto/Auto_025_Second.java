package org.firstinspires.ftc.team3736.a_opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.team3736.b_hardware.Hardware;

@SuppressWarnings("unused")
@Autonomous(name="FF: ¼s Forward", group="Auto", preselectTeleOp = "FF: TeleOp")
//@Disabled
public class Auto_025_Second extends LinearOpMode {

    //Declare Members
    private final ElapsedTime runtime = new ElapsedTime();


    static final double     FORWARD_SPEED       = 0.8;
    static final double     FORWARD_TIME        = 0.25;

    @Override
    public void runOpMode() {

        //Get Hardware
        final Hardware robot = new Hardware(hardwareMap);

        //Telemetry
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        //Wait for START
        waitForStart();

        //Drive forward
        robot.leftMotor.set(FORWARD_SPEED);
        robot.rightMotor.set(-FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < FORWARD_TIME )) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        telemetry.addData("Path", "Complete");
        telemetry.update();
    }
}