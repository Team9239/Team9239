package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Drive Forward")
public class driveForwardAuto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftDriveMotor = null;
    DcMotor rightDriveMotor = null;

    @Override
    public void runOpMode() throws InterruptedException {


        leftDriveMotor = hardwareMap.dcMotor.get("left drive motor");
        rightDriveMotor = hardwareMap.dcMotor.get("right drive motor");

        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftDriveMotor.setDirection(DcMotor.Direction.FORWARD);
        rightDriveMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() <= 1.1)
        {
            leftDriveMotor.setPower(1.0);
            rightDriveMotor.setPower(1.0);
            idle();
        }
        leftDriveMotor.setPower(0.0);
        rightDriveMotor.setPower(0.0);
        idle();

    }
}
