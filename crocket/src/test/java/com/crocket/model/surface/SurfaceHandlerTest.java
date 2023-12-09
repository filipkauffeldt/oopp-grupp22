// package com.crocket.model.surface;

// import com.crocket.model.entity.Ball;
// import com.crocket.shared.SurfaceType;
// import com.crocket.model.Level1;

// import org.junit.Before;
// import org.junit.Test;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

// // 600x, 400y: Ice
// // 1400x, 1000y: Sand



// public class SurfaceHandlerTest {
//     Surface surface = new Grass(0, 0);
//     Surface surface2 = new Sand(100, 0);
//     Surface surface3 = new Ice(200, 0);
//     Ball ball = new Ball(19, 19, 50, 50, 2);
//     Level1 level = new Level1();

//     @Test
//     public void testIntersects(){
//         assertTrue(SurfaceHandler.intersects(ball, surface));
//     }

//     @Test
//     public void test_get_friction_for_grass(){
//         assertEquals(0.1, SurfaceHandler.getFrictionConstant(ball, surface), 0.0001);
//     }

//     @Test
//     public void test_get_friction_for_sand(){
//         ball.setxPosition(150);
//         assertEquals(0.2, SurfaceHandler.getFrictionConstant(ball, surface2), 0.0001);
//     }

//     @Test
//     public void test_get_friction_for_ice(){
//         ball.setxPosition(250);
//         assertEquals(0.05, SurfaceHandler.getFrictionConstant(ball, surface3), 0.0001);
//     }
// }
